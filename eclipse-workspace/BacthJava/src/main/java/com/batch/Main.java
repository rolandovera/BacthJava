package com.batch;

import java.util.logging.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final String LOG_DECORATOR = "****************************************.";
	private static final Logger LOG = Logger.getLogger("batch");
	private static final Long MIL = 1000L;
	private static ApplicationContext context;

	private Main() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) throws Exception {

		LOG.info(LOG_DECORATOR);
		LOG.info(" INICIO DEL PROCESO ");
		LOG.info(LOG_DECORATOR);

		LOG.info("Cargando datos de configuracion");

		long tiempoComenzar;
		long tiempoTerminar;
		tiempoComenzar = System.currentTimeMillis();

		try {

			String[] springConfig = { "JobConfig.xml" };

			context = new ClassPathXmlApplicationContext(springConfig);

			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

			Job job = (Job) context.getBean("hellosuperjobjava");

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

			LOG.info("Job Status : " + execution.getStatus());
			LOG.info("Job completed");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			tiempoTerminar = System.currentTimeMillis();
			final long tiempoDedicado = (tiempoTerminar - tiempoComenzar) / MIL;
			LOG.info(
					"Fin. Tiempo dedicado a la consulta: ".concat(String.valueOf(tiempoDedicado)).concat(" segundos."));
			LOG.info(LOG_DECORATOR);
			LOG.info(" FIN DEL PROCESO ");
			LOG.info(LOG_DECORATOR);
		}

	}
}
