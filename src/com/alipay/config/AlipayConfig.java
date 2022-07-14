package com.alipay.config;

public class AlipayConfig {
    // 商户appid
    public static String APPID = "2021000121624047";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCRkIIr6bjd3lpOToSGQ2NMWeGan3Zpyqqnhe4WiybnHOAlrIcBZTYBi5mhdCp3/1GX0qtQ5ybWn4vqRTqx9475spReAVbpZztprX10i5RUgQ/QnjT8fmRB/A3rKEaio214rcabXmNQjaFdfyZHNMhsm+gPWGGoc7wmzNg8jm6J+mYXUsRfZ5gvsx4uyPg5w2Z2qxoHE7+vupr1NT0TVqP6JLM2O4yd7NbHZCf6Bo0y2h2zBSnsFQe1MCmSU1C7aT+Y07lQK0KxGJXle7QEQSrZuawZqC4F3syg/AP76VSYmMcmGc/61P4s/EJ/B7GNF+AXPdEA1n/OC+tnOQmvYlQ5AgMBAAECggEAem+mTfFlAZmJM9xvM89yskHXtQrzusAxEn9gZ63bpwFut8GKPO44oswdCOSA5DXpF16nooEK9fN06DQazp5/sB85FGjkBaZDHvxCTckplnqIJt0rjEVzZtzviCB0aVA1QBBKwVx/BL5cQBw2wiXvfwsUAfRBEENouuoJ58WVzI9/4zKaaRQaJ1zI7k5rJXsAAJBi0805MCzkM1bhHhr8Nj/4iS0x/2JOmBzu81aZwsuvHma6Gf0JChxJFfm6XGXG+/oNI2M/iEe/G6tW9G+durrazfsJ+VbhseEND/QFNWgp5Zr7SquvNkbTqPEQb1rK+EBVnV8ceJw8l3Gg/ML3QQKBgQDOQmqazSJnfdRBrFONqqLC2tp7DmOdemcbDw8LEVuHFB0lqboWwMhqOb/UjfI3mahS3esjbn9V0/ME1klT641A1vdubcjr2hWAL/ywd2f/vCc+H4vyNjG7mpSoTj3eywVHe3nVWXpiBKamJ9q0ycscGqlFeUncMlNdVzzYxHojxQKBgQC0qwr8SKjIBRQnyPVv9xuPld5ji4POVG6LghU7qa/xQdBskhIP6harG2ZcE9W1Y9Ftm1uib28BQqWVS+F9WZ7dCHuZAnHuBBme5c0+vD47ZWKgKpE6NkAaN3z3nyzbdulOTRISDB3gFPytTUCr/b6XIRrACWm1A/yFIPQbv4NR5QKBgH+h5anJCmMUIAZLhqCBWJpPJydCri3Cko7R8LMemI6ryaWGs5pkzR++gJAdDieNs/UjUd/o/m6z6wuxNkrx1cSrwQzabpxTpT5fc3QXT4mWeoocp1LIaln2u8qyL+LvqmKja66z4eFJk33554I75K2NafWNqkDR+3glBYf1fMcpAoGBAKZvY6Fh9kq9kwHLuX8576Po9oRRxEzRrzzJy3G5MqJYdP9v2T/b8KIUjcmJZDjECeylUFdlvKc2lH/i9YmahCUvaV1dyULxeADPxrJijBn/nknarQspawg70d30P0i2VNuTWHBTxTnnW5bzMf6/tVJYZuI+Sak+UOT7pKXjWcCZAoGBAIC48NcnXJN2M/WVw88MYlgdTtODcD+0EKphvbEhOHNnj8SesMMAPlEZT7AtRjk6BR2O8CTulji6VekC5Bpc7RU+lJmuFSsx7kJcBOmtPCJTWIRHHpyTjtNPjyZr4UNshTyl+UtANAK9qBhytbJNFGKvgOyEZplDEtarXgC25IwH";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/xiaomi/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8080/xiaomi/return_url.jsp";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAozZfHYCZ7b69iQGf/qBa5eh0dIJUG0RGXhOHP8M+pYAzhSv/DChPEgCKCue/bj1iRSoZDbEMVBJAH/9SyQlzJsKNiRTo9pdVPZ2E83O/UHSgp6Zok+YJT4Bnw5TWH5tA5Y24e5WIofZxUBHAfm9ll2s+Ds+BJA1iv3Z1HfYzGzaOipUxZRB5lSMbguLRh9qy9gU5tPWokrkBD60ZyoVURYcYZDpPckDsa7AzX+w5GVg1ydbeVB/8VbcBDeatEvmyCyvqij/1vouTg9TxVr6BOPgqVKvjly7YTyPJ99jIHzAVcylkZ+EVbqoRBJco0XoU/xKRa0cuQ/dZ++XFzdsEdQIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
