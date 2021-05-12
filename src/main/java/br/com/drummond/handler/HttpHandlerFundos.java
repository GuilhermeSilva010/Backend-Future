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

	public void handleRowsMessages(APIReturn response, int code, Object model) {
		if (code == 200) {
			response.setMsg("OK");
			response.setCode(200);
			response.setData(model);
		} else if (code == 400) {
			response.setCode(400);
			response.setMsg("BAD_REQUEST");
			response.setData(null);
		}
	}

	public void handleListMessages(APIReturn response, int code, Object model) {
		if (code == 200) {
			response.setCode(200);
			response.setData(model);
			response.setMsg("FUNDO_LIST_SUCCESSFULLY");
		} else if (code == 404) {
			response.setCode(404);
			response.setData(null);
			response.setMsg("FUNDO_NOT_FOUND");
		} else if (code == 400) {
			response.setCode(400);
			response.setMsg("BAD_REQUEST");
			response.setData(null);
		} else if (code == 503) {
			response.setCode(503);
			response.setMsg("SERVICE_UNAVAILBLE_CORE");
			response.setData(null);
		}
	}

}
