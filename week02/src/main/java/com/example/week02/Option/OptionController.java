package com.example.week02.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @GetMapping
    public List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }

    @GetMapping("/{id}")
    public Option getOptionById(@PathVariable String id) {
        return optionService.getOptionById(id);
    }

    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.createOption(option);
    }

    @PutMapping("/{id}")
    public Option updateOption(@PathVariable String id, @RequestBody Option option) {
        return optionService.updateOption(id, option);
    }

    @DeleteMapping("/{id}")
    public void deleteOption(@PathVariable String id) {
        optionService.deleteOption(id);
    }
}
