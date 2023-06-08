package ma.sir.pmp.zynerator.process;

import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

public abstract class AbstractProcessImpl<I extends AbstractProcessInput, K extends AbstractProcessOutput, T extends AuditBusinessObject,CONV extends AbstractProcessConverter<I, K, T>> {

    protected AbstractProcessConverter<I, K, T> converter;

    public AbstractProcessImpl(CONV converter) {
        this.converter = converter;
    }

    public Result<I, K, T> execute(I input) {
        Result<I, K, T> result = new Result();
        result.setInput(input);
        T item = converter.toItem(input);
        result.setItem(item);
        init(input, item);
        validate(input, item, result);
        if (result.hasNoError()) {
            run(input, item, result);
        } else {
            cleanUp(input, item, result);
        }
        K output = converter.toOutput(item);
        result.setOutput(output);
        result.constructTextMessage();
        result.setItem(null);
        return result;
    }

    public void cleanUp(I input, T item, Result<I, K, T> result) {
    }

    public void init(I input, T item) {

    }

    public void validate(I input, T item, Result<I, K, T> result) {

    }

    public abstract void run(I input, T item, Result<I, K, T> result);

    }