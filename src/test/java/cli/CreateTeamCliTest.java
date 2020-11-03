package cli;


import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


class CreateTeamCliTest {
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

}
