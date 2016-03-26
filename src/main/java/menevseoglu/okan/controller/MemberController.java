package menevseoglu.okan.controller;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by okanm on 25.03.2016.
 */
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String helloWorld() {
        return "HELLO";
    }
}