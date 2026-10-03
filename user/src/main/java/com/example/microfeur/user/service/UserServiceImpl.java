package com.example.microfeur.user.service;

import com.example.microfeur.user.grpc.UserReply;
import com.example.microfeur.user.grpc.UserRequest;
import com.example.microfeur.user.grpc.UserServiceGrpc;
import com.example.microfeur.user.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserReply> responseObserver) {
        Integer userId = Integer.parseInt(request.getId());
        var userOpt = userRepository.findById(userId);

        UserReply reply;
        if (userOpt.isPresent()) {
            var u = userOpt.get();
            reply = UserReply.newBuilder()
                    .setId(String.valueOf(u.getId()))
                    .setNom(u.getNom())
                    .setPrenom(u.getPrenom())
                    .setExists(true)
                    .build();
        } else {
            reply = UserReply.newBuilder()
                    .setId(request.getId())
                    .setExists(false)
                    .build();
        }

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}