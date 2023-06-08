package ma.sir.pmp.zynerator.process;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<I, K,T> {
    private List<Message> messages;
    private List<Message> errors;
    private List<Message> warnings;
    private List<Message> infos;
    private HttpStatus status = HttpStatus.OK;
    private String message;
    private T item;
    private I input;
    private K output;


    public Result(HttpStatus status) {
        this.status = status;
    }

    public Result(I input, K output) {
        this.input = input;
        this.output = output;
    }

    public Result() {

    }

    public boolean hasNoError() {
        return getErrors().isEmpty();
    }

    public void addErrorMessage(String message) {
        addMessage(message, MessageType.ERROR);
        this.status = HttpStatus.PRECONDITION_FAILED;
    }

    public void addInfoMessage(String message) {
        addMessage(message, MessageType.INFO);
        this.status = HttpStatus.OK;
    }

    public void addWarningMessage(String message) {
        addMessage(message, MessageType.WARN);
        this.status = HttpStatus.SEE_OTHER;
    }

    private void addMessage(String messageText, MessageType type) {
        Message myMessage = new Message(messageText, type);
        if (type == MessageType.ERROR) {
            getErrors().add(myMessage);
        } else if (type == MessageType.WARN) {
            getWarnings().add(myMessage);
        } else if (type == MessageType.INFO) {
            getInfos().add(myMessage);
        }
        getMessages().add(myMessage);
    }

    public void constructTextMessage() {
        if (message == null) {
            message = "";
        }
        List<Message> myMessages = getMessages();
        for (Message myMessage : myMessages) {
            message += myMessage.getLabel() + ", ";
        }
        if (!message.isEmpty())
            message = message.substring(0, message.length() - 2);
    }

    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public I getInput() {
        return input;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }


    public K getOutput() {
        return output;
    }

    public void setOutput(K output) {
        this.output = output;
    }

    public List<Message> getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<Message> errors) {
        this.errors = errors;
    }

    public List<Message> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<Message> warnings) {
        this.warnings = warnings;
    }

    public List<Message> getInfos() {
        if (infos == null) {
            infos = new ArrayList<>();
        }
        return infos;
    }

    public void setInfos(List<Message> infos) {
        this.infos = infos;
    }

}

