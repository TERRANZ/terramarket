package ru.terra.terramarket.engine;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.UserJpaController;
import ru.terra.terramarket.db.entity.User;
import ru.terra.server.dto.UserDTO;

import javax.persistence.NoResultException;
import java.util.List;

public class UsersEngine extends AbstractEngine<User, UserDTO> {

    private static final Logger logger = LoggerFactory.getLogger(UsersEngine.class);

    public UsersEngine() {
        super(new UserJpaController());
    }

    public Integer registerUser(String login, String password) {
        if (((UserJpaController) jpaController).findUser(login) != null) {
            return -1;
        } else {
            User u = new User();
            u.setLogin(login);
            u.setPass(password);
            u.setName("");
            createBean(u);
            return u.getId();
        }
    }

    public Integer getUserId(String login) {
        User u = ((UserJpaController) jpaController).findUser(login);
        return u != null ? u.getId() : -1;
    }

    public User findUser(String login, String password) {
        return ((UserJpaController) jpaController).findUser(login, password);

    }

    public User findUserByName(String name) {
        logger.info("findUserByName " + name);
        User u = null;
        try {
            u = ((UserJpaController) jpaController).findUser(name);
        } catch (NoResultException e) {
            logger.info("error while loading user " + e.getMessage());
            e.printStackTrace();
        }
        return u;
    }


    @Override
    public List<User> listBeans(Boolean all, Integer page, Integer perPage) {
        throw new NotImplementedException();
    }

    @Override
    public boolean updateDTO(UserDTO userDTO) {
        return false;
    }

    @Override
    public List<UserDTO> listDtos(Boolean all, Integer page, Integer perPage) {
        throw new NotImplementedException();
    }

    @Override
    public UserDTO getDto(Integer id) {
        return new UserDTO(getBean(id));
    }

    @Override
    public void dtoToEntity(UserDTO userDTO, User user) {

    }

    @Override
    public UserDTO entityToDto(User user) {
        return new UserDTO(user);
    }
}
