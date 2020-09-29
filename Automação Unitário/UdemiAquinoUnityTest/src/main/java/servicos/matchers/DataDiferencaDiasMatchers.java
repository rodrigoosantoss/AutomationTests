package servicos.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import utils.DataUtils;

import java.util.Date;

public class DataDiferencaDiasMatchers extends TypeSafeMatcher<Date> {

    private Integer qtdDias;

    public DataDiferencaDiasMatchers(Integer qtdDias) {
        this.qtdDias = qtdDias;
    }

    @Override
    protected boolean matchesSafely(Date data) {
        return DataUtils.isMesmaData(data, DataUtils.obterDataComDiferencaDias(qtdDias));
    }

    @Override
    public void describeTo(Description description) {

    }
}
