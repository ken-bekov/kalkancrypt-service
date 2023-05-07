package kz.talgau.crypto.controllers;

import kz.gov.pki.kalkan.jce.provider.cms.CMSSignedData;
import kz.gov.pki.provider.utils.CMSUtil;
import kz.talgau.crypto.domain.ShortSingerInfo;
import kz.talgau.crypto.domain.SubjectDN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class CMSController {

    private Provider kalkanProvider;

    @Autowired
    CMSController(Provider kalkanProvider) {
        this.kalkanProvider = kalkanProvider;
    }

    @PostMapping("singer-info")
    public List<ShortSingerInfo> getSingerInfo(@RequestBody CmsContent content) {
        List<ShortSingerInfo> infoList = new ArrayList<>();
        try {
            byte[] data = Base64.getDecoder().decode(content.getData());
            CMSSignedData cmsSignedData = CMSUtil.parseAsCMS(data);
            List<X509Certificate> certs = CMSUtil.getSignerCertificates(cmsSignedData, kalkanProvider);
            for (X509Certificate cert : certs) {
                String subjectDNStr = cert.getSubjectDN().toString();
                ShortSingerInfo info = new ShortSingerInfo();
                info.setSubjectDN(SubjectDN.parse(subjectDNStr));
                info.setStartTime(cert.getNotBefore());
                info.setEndTime(cert.getNotAfter());
                infoList.add(info);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return infoList;
    }
}

class CmsContent {
    private String data;

    String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
