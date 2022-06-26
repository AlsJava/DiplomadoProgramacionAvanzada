package edu.aluismarte.diplomado.project.week10.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
