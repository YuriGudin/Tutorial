package starter.observable_string_builder;

/*
* Написать Observable StringBuilder. Для этого понадобится абстрактный классOnChangeListener c методом onChange(StringBuilder sb),
* который вызываетсявнутри собственного класса-наследника StringBuilder если тот изменился.
* */
abstract class OnChangeListener {
    abstract protected void onChange(ObservableStringBuilder sb);
}

class ObservableStringBuilder {

    private StringBuilder stringBuilder;
    private OnChangeListener onChangeListener;

    public OnChangeListener getOnChangeListener() {
        return onChangeListener;
    }

    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public ObservableStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public ObservableStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        onChange();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        onChange();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    protected void onChange() {
        if(onChangeListener != null)
            onChangeListener.onChange(this);
    }
}

public class TaskObservableStringBuilder {

    public static void main(String[] args) {

        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();
        observableStringBuilder.setOnChangeListener(new OnChangeListener() {
            @Override
            protected void onChange(ObservableStringBuilder sb) {
                System.out.println("Изменение: " + sb.toString());
            }
        });

        observableStringBuilder.append("123");
        observableStringBuilder.reverse();
        observableStringBuilder.append("123");
        observableStringBuilder.reverse();


        OnChangeListener onChangeListener = observableStringBuilder.getOnChangeListener();

    }
}