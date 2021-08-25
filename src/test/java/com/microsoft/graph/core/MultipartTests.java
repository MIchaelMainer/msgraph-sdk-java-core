package com.microsoft.graph.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for Multipart functionality -- dummy change
 */
public class MultipartTests {

	private Multipart multipart;

	@BeforeEach
    public void setUp() {
		multipart =  new Multipart();
	}

	@Test
	public void testCreatePartHeaderWithNameContenttypeFilename() {
		String actual = multipart.createPartHeader("hamilton", "image/jpg", "hamilton.jpg");
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; name=\"hamilton\"; filename=\"hamilton.jpg\"\r\nContent-Type: image/jpg\r\n\r\n";
        assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithContenttypeFilename() {
		String actual = multipart.createPartHeader(null, "image/jpg", "hamilton.jpg");
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; filename=\"hamilton.jpg\"\r\nContent-Type: image/jpg\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithNameContenttype() {
		String actual = multipart.createPartHeader("hamilton", "image/jpg", null);
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; name=\"hamilton\"\r\nContent-Type: image/jpg\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithContenttype() {
		String actual = multipart.createPartHeader(null, "image/jpg", null);
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data\r\nContent-Type: image/jpg\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeader() {
		String actual = multipart.createPartHeader(null, null, null);
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithNameFilename() {
		String actual = multipart.createPartHeader("hamilton", null, "hamilton.jpg");
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; name=\"hamilton\"; filename=\"hamilton.jpg\"\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithName() {
		String actual = multipart.createPartHeader("hamilton", null, null);
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; name=\"hamilton\"\r\n\r\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePartHeaderWithFilename() {
		String actual = multipart.createPartHeader(null, null, "hamilton.jpg");
		String expected = "--"+multipart.getBoundary()+"\r\nContent-Disposition: form-data; filename=\"hamilton.jpg\"\r\n\r\n";
		assertEquals(expected, actual);
	}
}
