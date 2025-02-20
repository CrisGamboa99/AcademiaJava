package com.proyectoFinal.springBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

// Se define la clase que implementa el JobExecutionListener, este se activa después de que un 
// trabajo en Spring Batch ha terminado
public class ProyectoBatchJobExecutionListener implements JobExecutionListener {

	// Para registrar información
    private static final Logger LOGGER = LoggerFactory
    		.getLogger(ProyectoBatchJobExecutionListener.class); // LoggerFactory para crear una 
    												// instancia del logger asociada a esta clase

    // Método que se llama después de que se completa la ejecución del trabajo
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("JOB FINALIZADO. verifica los resultados");
        }
    }
    
}
