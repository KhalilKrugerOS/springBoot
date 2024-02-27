package com.crudOperaions.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    ClientRepository repository;
    @RequestMapping(value= "/client", method= RequestMethod.POST)

    public void save (@RequestBody Client client) {
        repository.save(client);
    }
    @RequestMapping(value="/client", method= RequestMethod.PUT)

    public void update(@RequestBody Client client){
        repository.save(client);
    }
    @RequestMapping(value="/client/{id}", method = RequestMethod.GET)
    public Client get(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
