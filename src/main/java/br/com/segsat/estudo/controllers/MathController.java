package br.com.segsat.estudo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.segsat.estudo.converters.NumberConverter;
import br.com.segsat.estudo.exceptions.UnsupportedMathOperationException;
import br.com.segsat.estudo.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	private final AtomicLong counter = new AtomicLong();
	

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
			
		}
		return math.sub( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
		}
		
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/mut/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mut(@PathVariable(value="numberOne") String numberOne, 
					  @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
		}
		
		return math.mut(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/raiz/{numeric}", method = RequestMethod.GET)
	public Double raiz(@PathVariable(value = "numeric") String numeric) throws Exception {
		if(!NumberConverter.isNumeric(numeric)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
		}
		return math.raiz(NumberConverter.convertToDouble(numeric));
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable(value="numberOne")String numberOne,
				@PathVariable(value="numberTwo")String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Porfavor insira um valor numerico");
		}
		return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
}
