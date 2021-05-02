package com.vaesco.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.123456789";
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEA0Q5IJZ6NU3OqokxGkKIb4xmE9l0avrLf0ANEvTA8JIj7NNU4\r\n"
			+ "mdB5FMaHnMHVIl2MUe8BbTBl1AGYZCodjcCz4ywRtbqqZREqKKHxmY3H6eR6UzaN\r\n"
			+ "lmIethiW/qz2ObyglCpxZyUtIerCbjn0gxQ7wbsn+GY+8DggLpJ9WuFU0E5gTJ3V\r\n"
			+ "3tyr1jb/wLy4vvxViJyvKXADkBgQ9kk+9N4QfRd0aBE23mm+7kYOPjphEPnLulIv\r\n"
			+ "gLoOF0IXqAww2bosmYCKLbBBnGwCFnLMe65qTBHLf99g2BmTS2PAxTa9uk9bODdQ\r\n"
			+ "K6ZqdLumSs2Mn15KXAv47Ur35N52fXF1IgAl1QIDAQABAoIBAGPuz84r3KLnx8mN\r\n"
			+ "bK320B3fNRAPsZk3KIXnChTl2dodIPhAdK4SWc70mB73CUtELK998NChMgwGNzKq\r\n"
			+ "bzYzx8nwZwbYFFv7uItz3mnovIeyEEd27HfWr5ecaZGUXJ9868XoBA2qV8i+z/Kh\r\n"
			+ "AaEnKumQ7apwNeXe7oNUw1eOH1zzPSbmQeFyRq/tyAnUO9QGIWnh6UJe8QAjBsL0\r\n"
			+ "eKEKTK7Wa9ypwrOOysm2CPMOHBTG6R6182GK+gq3U09xLNwDKQL6ViUJm7s/RjZ9\r\n"
			+ "79/gPzubbraNLO2OA4t+breBF5BUItUa+5sYhYzCmCEC9XWKl9LKfKTtxYWrPHXm\r\n"
			+ "+5ADfIECgYEA6UfscFbbKXcABGw4xU6DSxqh7h2yAwwof3ToZ3HYDJ7gHW8FoVpr\r\n"
			+ "lguYIpiJIqV0pTgfnNEybN1v/UZhlU15h2kMSeMayDIQFgGy0veuZBanD6eqkEk3\r\n"
			+ "KnHuCTaddwGBwbZWSHy+nBwY2WoPy7CwD8DEqSYV2GHeexc5hzY8TicCgYEA5Wpi\r\n"
			+ "nbBfUXR9Y3jkqA/3bWdqQSRBX7SrySd219voF8wl3PZA7vewxZR8m45+IRwAl21J\r\n"
			+ "LMYIDt/8vgUP1cCubjnXJquZY+752dw73pmSd3fhGuFkYK7T40fLAq/wwLIrlHan\r\n"
			+ "Gpd34eo4VVjOTjLt7HEo2j4Z17RI67NUjPszZaMCgYEA6P/vhl0aVZYILGKzaU78\r\n"
			+ "EB2vsxdx311bbcKlBf1NX32oN33WT8zyPFGkSJm2DybXFNazrHu+M8IQwxZzDR7u\r\n"
			+ "zXL81SfCbkaijnhv1guQ4WNGxXogADFAqmJU8FreeCjHI2YtVAVUlLPzleQ7lqUJ\r\n"
			+ "lRJi2texZgiKoMMXsJdZMG0CgYEAnjQw8WFROhDE7zXNKQBpti5cnbNsyZ0D4eGv\r\n"
			+ "GMhzUwXbDnda6/AvHPF6xKMM47Q1zDb3AUNHB0r7Neaztsn6/9QvRGGNk9aWweAY\r\n"
			+ "ATeSQ4SN3UWVPP8S62b03lOKCLhVSTpRngraBxbH5kMpcc+5NxYKAAZXN+MBbljq\r\n"
			+ "c5Y/KVUCgYA4tYM46z1IvIHDvrjMZWp8g4pl/CuU13WuzeI/0vdji5XlinFg32t9\r\n"
			+ "H+hOVHbGi3qLLXEF46dbiERQZ0i2hDSVuDP/dXkihKsKcMzvOmg/V1FOOT/WUg4J\r\n"
			+ "pDwMVot8lAWcbo1pHqOPaXAXArFKaXlbXOHasA4PXpcBmecVbPu5Jg==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC ="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Q5IJZ6NU3OqokxGkKIb\r\n"
			+ "4xmE9l0avrLf0ANEvTA8JIj7NNU4mdB5FMaHnMHVIl2MUe8BbTBl1AGYZCodjcCz\r\n"
			+ "4ywRtbqqZREqKKHxmY3H6eR6UzaNlmIethiW/qz2ObyglCpxZyUtIerCbjn0gxQ7\r\n"
			+ "wbsn+GY+8DggLpJ9WuFU0E5gTJ3V3tyr1jb/wLy4vvxViJyvKXADkBgQ9kk+9N4Q\r\n"
			+ "fRd0aBE23mm+7kYOPjphEPnLulIvgLoOF0IXqAww2bosmYCKLbBBnGwCFnLMe65q\r\n"
			+ "TBHLf99g2BmTS2PAxTa9uk9bODdQK6ZqdLumSs2Mn15KXAv47Ur35N52fXF1IgAl\r\n"
			+ "1QIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
