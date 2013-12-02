package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SFuture {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//		FutureTask<Long> futureTask = new FutureTask<>(getCallable());
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Long> future = executorService.submit(getCallable(1,22));
		
		System.out.print("Now time is: "+ future.get(2, TimeUnit.SECONDS));
		
//		boolean wait = true;
//		while (wait) {
//			if (future.isDone()) {
//				System.out.print("Now time is: "+ future.get());
//				wait = false;
//			}else {
//				Thread.currentThread().sleep(1000);
//			}		
//		}
		
		executorService.shutdownNow();
	}
	
	
	
	private static Callable<Long> getCallable(final int begin, final int end){
		Callable<Long> callable = new Callable<Long>() {
			@SuppressWarnings("static-access")
			@Override
			public Long call() throws Exception {
//				Thread.currentThread().sleep(3000);
				long nowTime = begin + end;
				return nowTime;
			}
		};
		return callable;
	}

}
