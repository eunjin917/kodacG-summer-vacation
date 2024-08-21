package com.example.week02.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public Option getOptionById(String id) {
        return optionRepository.findById(id).orElse(null);
    }

    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    public Option updateOption(String id, Option option) {
        Option existingOption = optionRepository.findById(id).orElse(null);
        if (existingOption != null) {
            // 필드 이름에 맞게 수정
            existingOption.setOption_name(option.getOption_name());
            existingOption.setOption_price(option.getOption_price());
            existingOption.setProduct(option.getProduct()); // Product 객체로 설정

            return optionRepository.save(existingOption);
        }
        return null;
    }

    public void deleteOption(String id) {
        optionRepository.deleteById(id);
    }
}
