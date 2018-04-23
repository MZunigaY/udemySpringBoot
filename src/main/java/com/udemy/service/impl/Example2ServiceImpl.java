package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.Example2Service;

@Service("example2Service")
public class Example2ServiceImpl implements Example2Service{
	
	private static final Log LOG = LogFactory.getLog(Example2ServiceImpl.class);

	@Override
	public void mostrarMensajeLog() {
		LOG.info("ENTRO AL SERVICIO 2 !! ");
	}

}
