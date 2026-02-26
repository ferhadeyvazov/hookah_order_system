package hos.hookahordersystem.hookah_device.repository;

import hos.hookahordersystem.hookah_device.entity.HookahDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookahDeviceRepo extends JpaRepository<HookahDevice, Integer> {
    // save, read, update, delete


    @Override
    <S extends HookahDevice> S save(S entity);
}
