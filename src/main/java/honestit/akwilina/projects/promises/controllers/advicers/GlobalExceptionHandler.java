package honestit.akwilina.projects.promises.controllers.advicers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String returnErrorPage(Exception exception, Model model) {
        log.warn("Złapano wyjątek: {}", exception.getMessage(), exception);
        model.addAttribute("exception", exception);
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(arrayStream, true, "UTF-8");
            exception.printStackTrace(printStream);
            String stackTrace = new String(arrayStream.toByteArray(), "UTF-8");
            model.addAttribute("stackTrace", stackTrace);
        } catch (UnsupportedEncodingException e) {
            log.warn("Błąd kodowania", e);
        }
        return "errors/error";
    }
}
