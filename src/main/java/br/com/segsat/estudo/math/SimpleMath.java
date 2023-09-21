package br.com.segsat.estudo.math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {

		return numberOne + numberTwo;
	}

	public Double sub(Double numberOne, Double numberTwo) {

		return numberOne - numberTwo;
	}

	public Double div(Double numberOne, Double numberTwo) {

		return numberOne / numberTwo;
	}

	public Double mut(Double numberOne, Double numberTwo) {

		return numberOne * numberTwo;
	}

	public Double raiz(Double numeric) {
		return Math.sqrt(numeric);
	}

	public Double media(Double numberOne, Double numberTwo) {

		return (numberOne + numberTwo) / 2;
	}

}
