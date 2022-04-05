package main;

@FunctionalInterface
public interface InterfazGenericOperation<T> {
	T operation(T op1,T op2);
}
