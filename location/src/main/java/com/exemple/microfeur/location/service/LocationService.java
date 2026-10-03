package com.exemple.microfeur.location.service;

import com.example.microfeur.user.grpc.UserReply;
import com.example.microfeur.user.grpc.UserRequest;
import com.example.microfeur.user.grpc.UserServiceGrpc;
import com.exemple.microfeur.location.model.Location;
import com.exemple.microfeur.location.repository.LocationRepository;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    public Location enregistrerLocalisation(Location location) {
                UserRequest request = UserRequest.newBuilder()
                .setId(String.valueOf(location.getUserId()))
                .build();
        UserReply reply = userStub.getUser(request);

        if (!reply.getExists()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur introuvable");
        }

        if (location.getTimestamp() == null) {
            location.setTimestamp(LocalDateTime.now());
        }
        return locationRepository.save(location);
    }

    public List<Location> getLocationsByUserId(Integer userId) {
        return locationRepository.findByUserId(userId);
    }

    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }
}