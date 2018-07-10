/**
 * 阿里云OSS配置类
 */

@ConfigurationProperties(prefix = "oss")
@Component
public class OssConfig {

    private String scheme;

    private String accessKey;

    private String endpoint;

    private String accessSecret;

    private String bucket;

    private Long fileLimitSize;

    private Long expireTime;

    private String imgBaseUrl;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public Long getFileLimitSize() {
        return fileLimitSize;
    }

    public void setFileLimitSize(Long fileLimitSize) {
        this.fileLimitSize = fileLimitSize;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getImgBaseUrl() {
        return imgBaseUrl;
    }

    public void setImgBaseUrl(String imgBaseUrl) {
        this.imgBaseUrl = imgBaseUrl;
    }
}
