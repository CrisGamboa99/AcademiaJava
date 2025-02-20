package com.proyectoFinal.springBatch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.proyectoFinal.springBatch.EmpleadoItemProcessor;
import com.proyectoFinal.springBatch.bo.EmpleadoBean;

// Clase donde se define todo el proceso de Spring Batch

@Configuration // Para indicar que es una clase de configuración
public class ProyectoBatchConfiguration {

	@Value("${file.input}") // Para inyectar el valor con la propiedad file.input del 
							// archivo application.properties
	private String fileInput;

	@SuppressWarnings({ "rawtypes", "unchecked" }) // Suprime advertencias del compilador 
													// relacionadas con tipos genéricos
	@Bean // Indica que el método creará un bean para que Spring lo gestione
	public FlatFileItemReader reader() { // El ItemReader (parte del Step), que lee el 
										// archivo .csv
		return new FlatFileItemReaderBuilder<>()
				.name("empleadoItemReader") // Nombre asignado al ItemReader
				.resource(new ClassPathResource(fileInput)) // Especifica el archivo a leer
				.linesToSkip(1) // Omite la primera línea del archivo
				.delimited() // Indica que es un archivo delimitado (csv)
				.names(new String[] { 
						"empId", "empNombre", "empDesc", "salario" }) // Los nombres de 
								// las columnas que corresponden a los campos de EmpleadoBean
				.fieldSetMapper(new BeanWrapperFieldSetMapper() { // Mapea las líneas leídas 
																// a un objeto EmpleadoBean
					{
						setTargetType(EmpleadoBean.class);
					}
				}).build(); // Construye el ItemReader con la configuración especificada
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) { // El ItemWriter (parte del
						// Step), que se encarga de la escritura de la información procesada
        return new JdbcBatchItemWriterBuilder<>()
            .itemSqlParameterSourceProvider(
            		new BeanPropertyItemSqlParameterSourceProvider<>()) // Mapea las propiedades
            									// del objeto EmpleadoBean a los parámetros SQL
            .sql("INSERT INTO empleado "
            		+ "(empId, empNombre, empDesc, salario) "
            		+ "VALUES (:empId, :empNombre, :empDesc, :salario)") // Define la consulta 
            								// SQL para insertar datos (No se usa Spring JPA)
            .dataSource(dataSource) // Especifica la base de datos donde se escribirán los 
            				// datos. El parámetro dataSource es la conexión a la base de datos
            .build();
    }

	// Se configura el Job
	@Bean
    public Job importEmpleadoJob(JobRepository jobRepository, 
    		JobExecutionListener listener, Step step1) { // JobRepository almacena información 
							// sobre la ejecución del job, JobExecutionListener escucha eventos
							// del job y Step1 es el paso que ejecutará el job
        return new JobBuilder("importEmpleadoJob", jobRepository) // Crea un Job con el nombre 
        					// importEmpleadoJob y usa el jobRepository para mantener el estado
            .incrementer(new RunIdIncrementer()) // Genera un nuevo ID de ejecución cada vez 
            									// que se ejecuta el job
            .listener(jobCompletionListener()) // Registra un listener que se ejecutará al 
            									// inicio y fin del job
            .flow(step1) // Define el flujo de ejecución del job (ejecuta el step1)
            .end() // Finaliza la configuración
            .build();
    }

	// Configuración del listener para el job
	@Bean
    public JobExecutionListener jobCompletionListener() {
        return new JobExecutionListenerSupport();
    }
	
    // Configuración del step1
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean
    public Step step1(JobRepository jobRepository, 
    		PlatformTransactionManager transactionManager, 
    		JdbcBatchItemWriter writer) { // jobRepository para gestionar el estado del step, 
    				// transactionManager para manejar las transacciones y writer el ItemWriter
        return new StepBuilder("step1", jobRepository) // Configura el nombre del step e indica 
        												// el jobRepository para los metadatos
            .<EmpleadoBean, EmpleadoBean>chunk
            			(5, transactionManager) // Para definir procesamientos por chunks o 
            									// lotes (5 segundos), se indica EmpleadoBean 
            									// ya que es el tipo de entrada y salida
            .reader(reader()) // Lee el archivo de entrada
            .processor(processor()) // Procesa cada registro leído
            .writer(writer) // Usa el JdbcBatchItemWriter definido
            .build();
    }

    // Configuración el processor para el job
    @Bean
    public EmpleadoItemProcessor processor() {
        return new EmpleadoItemProcessor();
    }
    
}
