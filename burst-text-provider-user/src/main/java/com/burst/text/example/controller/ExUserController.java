package com.burst.text.example.controller;

import com.burst.text.example.entity.User;
import com.burst.text.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @RestController 也是复合注解,包含了 @Controller 和 @ResponseBody
 */
@RestController
public class ExUserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @GetMapping 注解是一个复合注解，spring4.3开始提供的，包含 @RequestMapping
	 * 相当于：@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	 * 还有一些的他的类似注解：@PostMapping @PutMapping 等
	 * 
	 * 可以写成这样：@GetMapping(value="/simple/{id}", produces="application/json;charset=UTF-8")
	 * 注：produces = "text/html; charset=UTF-8" 写成这个会导致无法访问
	 *
	 * @RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	 */
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id) {
		/**Optional<User> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}**/
		User user = this.userRepository.findOne(id);
		if(null != user){
			return user;
		}
		return null;
	}
}
