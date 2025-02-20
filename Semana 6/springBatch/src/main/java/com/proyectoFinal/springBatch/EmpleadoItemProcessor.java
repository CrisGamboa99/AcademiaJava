package com.proyectoFinal.springBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.proyectoFinal.springBatch.bo.EmpleadoBean;

// Clase del Processor para transformar los datos de los empleados. Implementa la interfaz 
// ItemProcessor que toma un objeto de tipo EmpleadoBean como entrada y devuelve un objeto 
// también de tipo EmpleadoBean.
public class EmpleadoItemProcessor implements ItemProcessor<EmpleadoBean, EmpleadoBean> {

	// Para registrar información relevante durante el procesamiento
    private Logger LOGGER = LoggerFactory.getLogger(EmpleadoItemProcessor.class);

    // Definición del método que realiza la transacción
    @Override
    public EmpleadoBean process(final EmpleadoBean empleado) throws Exception {
        String salario = "$" + empleado.getSalario(); // Obtiene el salario del empleado y le 
        												// concatena $ al inicio
        
        // Se crea un nuevo objeto EmpleadoBean con los datos del empleado original pero con el
        // salario modificado
        EmpleadoBean transformedEmpleado = new EmpleadoBean(
        		empleado.getEmpId(), 
        		empleado.getEmpNombre(), 
        		empleado.getEmpDesc(), 
        		salario);
        
        // Para registrar un mensaje informativo en el log. Muestra el objeto empleado original
        // y el objeto nuevo
        LOGGER.info("Converting ( {} ) into ( {} )", empleado, transformedEmpleado);
        return transformedEmpleado; // Devuelve el nuevo objeto creado
    }
    
}
