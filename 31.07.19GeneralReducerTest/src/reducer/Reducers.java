package reducer;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Reducers {
	
	// immutable accumulators (wrapping classes and String)
	
	public static <R, T, U, A> R reduce(
			Iterable<T> source,
			Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiFunction<A,U,A> mergeWithAccumulatorFunction,
			Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get(); //create variable of type A which contatins all values
		for(T t : source) accumulator = mergeWithAccumulatorFunction.apply(accumulator,dataTransformFunction.apply(t)); //sum to accumulator all values
		return finalProcessingFunction.apply(accumulator); //final convert of values
		
	}
	
	
	//reducer without initial transform
	public static <R, T, U, A> R reduce(
			Iterable<T> source,
			//Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiFunction<A,T,A> mergeWithAccumulatorFunction,
			Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		for(T t : source) accumulator = mergeWithAccumulatorFunction.apply(accumulator,t);
		return finalProcessingFunction.apply(accumulator);
		
	}
	
	
	//reducer without final datatransform
	public static <R, T, U, A> A reduce(
			Iterable<T> source,
			Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiFunction<A,U,A> mergeWithAccumulatorFunction
			//Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		
		for(T t : source) {
			accumulator=mergeWithAccumulatorFunction.apply(accumulator,dataTransformFunction.apply(t));
			
		}
		return accumulator;
		
	}	
	
	
	//reducer without initial and final data transform
	public static <R, T, U, A> A reduce(
			Iterable<T> source,
			//Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiFunction<A,T,A> mergeWithAccumulatorFunction
			//Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		
		for(T t : source) {
			accumulator=mergeWithAccumulatorFunction.apply(accumulator,t);
			
		}
		return accumulator;
		
	}	
	
	
	
	
	// mutable accumulators
	
	public static <R, T, U, A> R reduce(
			Iterable<T> source,
			Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiConsumer<A,U> mergeWithAccumulatorFunction,
			Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		for(T t : source) mergeWithAccumulatorFunction.accept(accumulator,dataTransformFunction.apply(t));
		return finalProcessingFunction.apply(accumulator);
		
	}	
}
