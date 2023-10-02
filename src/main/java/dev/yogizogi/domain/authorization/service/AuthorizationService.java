package dev.yogizogi.domain.authorization.service;

import dev.yogizogi.domain.authorization.exception.AuthException;
import dev.yogizogi.domain.authorization.exception.FailLoginException;
import dev.yogizogi.domain.authorization.model.dto.request.LoginInDto;
import dev.yogizogi.domain.authorization.model.dto.response.LoginOutDto;
import dev.yogizogi.domain.user.exception.NotExistAccountException;
import dev.yogizogi.domain.user.model.entity.User;
import dev.yogizogi.domain.user.repository.UserRepository;
import dev.yogizogi.domain.security.service.JwtService;
import dev.yogizogi.domain.user.service.UserService;
import dev.yogizogi.global.common.code.ErrorCode;
import dev.yogizogi.global.common.status.BaseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final UserRepository userRepository;

    private final UserService userService;
    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public LoginOutDto login(LoginInDto req) throws AuthException {

        User findUser = userRepository.findByAccountNameAndStatus(req.getAccountName(), BaseStatus.ACTIVE)
                .orElseThrow(() -> new NotExistAccountException(ErrorCode.NOT_EXIST_ACCOUNT));

        if (!passwordEncoder.matches(
                req.getPassword(), findUser.getPassword()
        )) {
            throw new FailLoginException(ErrorCode.FAIL_TO_LOGIN);
        }

        return LoginOutDto.of(
                findUser.getId(),
                findUser.getAccountName(),
                jwtService.issueAccessToken(findUser.getId(), findUser.getAccountName()),
                jwtService.issueRefreshToken(findUser.getId(), findUser.getAccountName())
        );

    }

}
