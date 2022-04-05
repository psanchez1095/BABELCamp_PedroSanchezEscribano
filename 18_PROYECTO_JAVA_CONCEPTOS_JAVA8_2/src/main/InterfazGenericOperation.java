package main;

@FunctionalInterface
public interface InterfazGenericOperation<T> {
	/**
	 * Realiza una operacion entre dos operandos del mismo tipo
	 * @param op1 operando de tipo T
	 * @param op2 operando de tipo T
	 * @return T devuelve una referencia del mismo tipo que los parametros de entrada.
	 * Esto se definirá cuando se instancie el objeto
	 *  
	 *  */
	public T operation(T op1,T op2);
}
