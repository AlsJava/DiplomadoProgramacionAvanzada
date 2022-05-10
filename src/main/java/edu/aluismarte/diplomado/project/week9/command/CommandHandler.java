package edu.aluismarte.diplomado.project.week9.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
