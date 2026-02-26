package hos.hookahordersystem.hookah_device.service;

import hos.hookahordersystem.hookah_device.repository.HookahDeviceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class HookahDeviceService {
    private final HookahDeviceRepo hookahDeviceRepo;

    public HookahDeviceService(HookahDeviceRepo repository){
        this.hookahDeviceRepo = repository;
    }
}
