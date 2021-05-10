package br.com.drummond.handler;

import org.springframework.stereotype.Component;

import br.com.drummond.response.APIReturn;


@Component
public class HttpHandlerFundos {

	public void handleAddMessages(APIReturn response, int code, Object model) {

		if (code == 200) {
			response.setCode(200);
			response.setData(model);
			response.setMsg("SUCCESSFULLY_REGISTERED_BACKGROUND");
			response.setData(null);
			response.setMsg("BACKGROUND_ADDED_NOT_FOUND");
		} else if (code == 304) {
			response.setCode(304);
			response.setMsg("BACKGROUND_ALREADY_EXISTS");
			response.setData(null);
		} else if (code == 400) {
			response.setCode(400);
			response.setMsg("BAD_REQUEST");
			response.setData(null);
		}
	}
}
