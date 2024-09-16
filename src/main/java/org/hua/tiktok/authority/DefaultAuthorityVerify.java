package org.hua.tiktok.authority;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认权限验证
 */
public class DefaultAuthorityVerify implements AuthorityVerify{
    @Override
    public Boolean authorityVerify(HttpServletRequest request, String[] permissions) {
        return true;
    }
}
