package application;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApp {

	private static final int NUM_TASK = 100;
	private static final long THREAD_DELAY = 1000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(()->{
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
			System.out.println("thread");
		});
		
		executor.shutdown();
		System.out.println("main");*/
		/*for (int i = 0; i < NUM_TASK; i++) {
			executor.execute(()->{
				try {
					Thread.sleep(THREAD_DELAY);
				} catch (Exception e) {}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		Future<String> future = executor.submit(()->{
			try {
				Thread.sleep(THREAD_DELAY);
			} catch (Exception e) {}
			return Thread.currentThread().getName();
		});*/
		
		ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
		scheduled.scheduleAtFixedRate(()->{ 
			System.out.println(LocalTime.now());
		}
		, 1L, 1L, TimeUnit.SECONDS);
		
		//System.out.println(future.get());
		//scheduled.shutdown();
		System.out.println("main");
	}

}
