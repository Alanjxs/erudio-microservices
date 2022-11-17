package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.OperacaoNaoSuportada;

@RestController
public class MathController {

	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double sub = convertDouble(numberOne) - convertDouble(numberTwo);
		return sub;
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double mult = convertDouble(numberOne) * convertDouble(numberTwo);
		return mult;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double div = convertDouble(numberOne) / convertDouble(numberTwo);
		return div;
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double media = (convertDouble(numberOne) + convertDouble(numberTwo))/2;
		return media;
	}
	
	@RequestMapping(value="/raiz/{number}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("number") String number) throws Exception {
		if (!isNumeric(number)) {
			throw new OperacaoNaoSuportada("Por favor informar um valor numérico.");
		}
		Double raiz = Math.sqrt(convertDouble(number));
		return raiz;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	private Double convertDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}


}
