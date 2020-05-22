package honestit.akwilina.projects.promises.controllers.advicers;

import lombok.Data;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GlobalErrorsHandler implements ErrorController {

    @RequestMapping("/error")
    public String processErrors(HttpServletRequest req, HttpServletResponse res, Model model) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(res.getStatus());
        errorInfo.setPath((String) req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        model.addAttribute("errorInfo", errorInfo);
        return "errors/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @Data
    public static class ErrorInfo {

        private int code;
        private String path;
        private String message;
    }
}
