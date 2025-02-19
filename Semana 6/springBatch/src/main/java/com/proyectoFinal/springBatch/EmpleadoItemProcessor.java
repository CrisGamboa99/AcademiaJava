package com.proyectoFinal.springBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.proyectoFinal.springBatch.bo.EmpleadoBean;

public class EmpleadoItemProcessor implements ItemProcessor<EmpleadoBean, EmpleadoBean> {

    private Logger LOGGER = LoggerFactory.getLogger(EmpleadoItemProcessor.class);

    @Override
    public EmpleadoBean process(final EmpleadoBean empleado) throws Exception {
        String salario = "$" + empleado.getSalario();
        
        EmpleadoBean transformedEmpleado = new EmpleadoBean(
        		empleado.getEmpId(), 
        		empleado.getEmpNombre(), 
        		empleado.getEmpDesc(), 
        		salario);
        
        LOGGER.info("Converting ( {} ) into ( {} )", empleado, transformedEmpleado);
        return transformedEmpleado;
    }
    
}
