package co.com.resourceserver.spring_resource_server;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/foo")
public class WebController {

	@GetMapping(value = "/testfoo")
    public String testmethod() {
        return "welcome to testmethod";
    }
	
	@PreAuthorize("hasAuthority('FOO_READ')")
	//@GetMapping(value = "/readFoo")
    @RequestMapping(value = "/readFoo" ,method = RequestMethod.GET)
    public String readFoo() {
        return "welcome to read role";
    }

    @PreAuthorize("hasAuthority('FOO_WRITE')")
   // @GetMapping(value = "/writeFoo")
    @RequestMapping(value = "/writeFoo" ,method = RequestMethod.GET)
    public String writeFoo() {
        return "welcome to write role";
    }
    
    
    @PreAuthorize("hasAuthority('admin')")
   // @GetMapping(value = "/admin")
    @RequestMapping(value = "/admin" ,method = RequestMethod.GET)
    public String admin() {
        return "welcome to admin role";
    }
}
