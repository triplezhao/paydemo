package pay.demo.act;

import javax.inject.Inject;

final class DemoPresenter implements Demo.P {


    private Demo.V view;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    DemoPresenter(
            Demo.V view) {
        this.view = view;
    }


    @Override
    public void start() {

    }

    @Override
    public void loadData() {


    }
}