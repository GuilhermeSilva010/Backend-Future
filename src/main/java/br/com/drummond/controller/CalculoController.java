package br.com.drummond.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.drummond.converter.CalculoFundoConverter;
import br.com.drummond.handler.HttpHandlerFundos;
import br.com.drummond.model.CalculoFundo;
import br.com.drummond.request.ListPageRequest;
import br.com.drummond.response.APIReturn;
import br.com.drummond.response.CalculoFundoReponse;
import br.com.drummond.service.CalculoFundoService;

//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("")
@Controller
class CalculoController {


	@Autowired
	private CalculoFundoService calculoFundoService;


	@Autowired
	private CalculoFundoConverter calculoConverter;

	@Autowired
	private HttpHandlerFundos httpHandlerFundos;


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/calculo/list", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> getList(@RequestBody ListPageRequest listPageRequest) {

		APIReturn apiReturn = new APIReturn();
		try {

			List<CalculoFundo> calculo = calculoFundoService.getListPages(listPageRequest.getData(), listPageRequest.getPage(),
					listPageRequest.getRows());
			if (!calculo.isEmpty()) {
				List<CalculoFundoReponse> calculoResponse = calculoConverter.CalculoSavedToListItem(calculo);
				if (!calculoResponse.isEmpty())
					httpHandlerFundos.handleListMessages(apiReturn, 200, calculoResponse);
				else
					httpHandlerFundos.handleListMessages(apiReturn, 404, null);
			} else
				httpHandlerFundos.handleListMessages(apiReturn, 404, null);

			System.out.println(" :: Encerrando o método /api/calculo/list - 200 - OK :: ");
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			httpHandlerFundos.handleRowsMessages(apiReturn, 400, null);

			System.out.println(" :: Encerrando o método /api/calculo/list - 400 - BAD REQUEST :: ");

			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/calculo/list/count", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> count(@RequestBody ListPageRequest listPageRequest) throws IOException {
		APIReturn apiReturn = new APIReturn();
		try {

			apiReturn.setCode(200);
			apiReturn.setData(calculoFundoService.getCount(listPageRequest.getData()));
			apiReturn.setMsg("OK");

			System.out.println(" :: Encerrando o método /api/calculo/list/count - 200 - OK :: ");
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" :: Encerrando o método /api/calculo/list/count - 400 - BAD REQUEST :: ");
			httpHandlerFundos.handleRowsMessages(apiReturn, 400, null);
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.BAD_REQUEST);
		}
	}

}
