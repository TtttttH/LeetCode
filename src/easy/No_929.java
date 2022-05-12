package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.929 独特的电子邮件地址 (Microsoft)
 */
public class No_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String seen = email.substring(0, i);
            String rest = email.substring(i);
            seen = seen.split("\\+", 0)[0].replaceAll("\\.", "");
            set.add(seen + rest);
        }

        return set.size();
    }
}
