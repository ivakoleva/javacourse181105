package bg.clearcode.javacourse181105.day4;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class CountingFilterReader extends FilterReader {
    private int counter;

    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    protected CountingFilterReader(Reader in) {
        super(in);
    }

    public int getReadCounter() {
        return counter;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        counter++;
        return super.read(cbuf, off, len);
    }
}
