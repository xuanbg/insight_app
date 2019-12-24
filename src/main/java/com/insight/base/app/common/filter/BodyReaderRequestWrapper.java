package com.insight.base.app.common.filter;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

/**
 * @author 宣炳刚
 * @date 2017/10/6
 * @remark
 */
public class BodyReaderRequestWrapper extends HttpServletRequestWrapper {
    private ByteArrayOutputStream cachedBytes;

    public BodyReaderRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private void cacheInputStream() throws IOException {
        cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), cachedBytes);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (cachedBytes == null) {
            cacheInputStream();
        }

        return new CachedServletInputStream();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(getInputStream(), Charset.defaultCharset());
        return new BufferedReader(streamReader);
    }

    public class CachedServletInputStream extends ServletInputStream {
        private ByteArrayInputStream input;

        public CachedServletInputStream() {
            input = new ByteArrayInputStream(cachedBytes.toByteArray());
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
        }

        @Override
        public int read() {
            return input.read();
        }
    }
}
