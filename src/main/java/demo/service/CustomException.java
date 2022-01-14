package demo.service;

public class CustomException extends RuntimeException {

    public enum ErrorCode {
        BAD_CREDENTIALS,
        ANIMAL_COULD_NOT_BE_CREATED,
        ANIMAL_COULD_NOT_BE_READ,
        ANIMAL_COULD_NOT_BE_FOUND,
        ANIMAL_COULD_NOT_BE_UPDATED,
        ANIMAL_COULD_NOT_BE_DELETED,
        COMMENT_COULD_NOT_BE_CREATED,
        COMMENT_COULD_NOT_BE_READ,
        COMMENT_COULD_NOT_BE_FOUND,
        COMMENT_COULD_NOT_BE_UPDATED,
        COMMENT_COULD_NOT_BE_DELETED,
        FACT_COULD_NOT_BE_CREATED,
        FACT_COULD_NOT_BE_READ,
        FACT_COULD_NOT_BE_FOUND,
        FACT_COULD_NOT_BE_UPDATED,
        FACT_COULD_NOT_BE_DELETED,
        FEEDBACK_COULD_NOT_BE_CREATED,
        FEEDBACK_COULD_NOT_BE_READ,
        FEEDBACK_COULD_NOT_BE_FOUND,
        FEEDBACK_COULD_NOT_BE_UPDATED,
        FEEDBACK_COULD_NOT_BE_DELETED,
        IMAGE_COULD_NOT_BE_CREATED,
        IMAGE_COULD_NOT_BE_READ,
        IMAGE_COULD_NOT_BE_FOUND,
        IMAGE_COULD_NOT_BE_UPDATED,
        IMAGE_COULD_NOT_BE_DELETED,
        SUGGESTION_COULD_NOT_BE_CREATED,
        SUGGESTION_COULD_NOT_BE_READ,
        SUGGESTION_COULD_NOT_BE_FOUND,
        SUGGESTION_COULD_NOT_BE_UPDATED,
        SUGGESTION_COULD_NOT_BE_DELETED,
        SUGGESTION_COULD_NOT_BE_APPROVED,
        SUGGESTION_COULD_NOT_BE_REJECTED,
        SUGGESTION_ALREADY_APPROVED,
        RANDOM_FACT_COULD_NOT_BE_READ,
        REPOSITORY_COUNT_NOT_BE_FOUND_FOR_CLASS,
        OBJECT_COULD_NOT_BE_CREATED,
        OBJECT_COULD_NOT_BE_READ,
        OBJECT_COULD_NOT_BE_FOUND,
        OBJECT_COULD_NOT_BE_UPDATED,
        OBJECT_COULD_NOT_BE_DELETED
    }

    private ErrorCode error;

    private CustomException(ErrorCode error) {
        this.error = error;
    }

    public ErrorCode getError() {
        return error;
    }

    public static CustomException badCredentials() {
        return new CustomException(ErrorCode.BAD_CREDENTIALS);
    }

    public static CustomException animalCouldNotBeCreated() {
        return new CustomException(ErrorCode.ANIMAL_COULD_NOT_BE_CREATED);
    }
    public static CustomException animalCouldNotBeRead() {
        return new CustomException(ErrorCode.ANIMAL_COULD_NOT_BE_READ);
    }
    public static CustomException animalCouldNotBeFound() {
        return new CustomException(ErrorCode.ANIMAL_COULD_NOT_BE_FOUND);
    }
    public static CustomException animalCouldNotBeUpdated() {
        return new CustomException(ErrorCode.ANIMAL_COULD_NOT_BE_UPDATED);
    }
    public static CustomException animalCouldNotBeDeleted() {
        return new CustomException(ErrorCode.ANIMAL_COULD_NOT_BE_DELETED);
    }
    public static CustomException commentCouldNotBeCreated() {
        return new CustomException(ErrorCode.COMMENT_COULD_NOT_BE_CREATED);
    }
    public static CustomException commentCouldNotBeRead() {
        return new CustomException(ErrorCode.COMMENT_COULD_NOT_BE_READ);
    }
    public static CustomException commentCouldNotBeFound() {
        return new CustomException(ErrorCode.COMMENT_COULD_NOT_BE_FOUND);
    }
    public static CustomException commentCouldNotBeUpdated() {
        return new CustomException(ErrorCode.COMMENT_COULD_NOT_BE_UPDATED);
    }
    public static CustomException commentCouldNotBeDeleted() {
        return new CustomException(ErrorCode.COMMENT_COULD_NOT_BE_DELETED);
    }
    public static CustomException factCouldNotBeCreated() {
        return new CustomException(ErrorCode.FACT_COULD_NOT_BE_CREATED);
    }
    public static CustomException factCouldNotBeRead() {
        return new CustomException(ErrorCode.FACT_COULD_NOT_BE_READ);
    }
    public static CustomException factCouldNotBeFound() {
        return new CustomException(ErrorCode.FACT_COULD_NOT_BE_FOUND);
    }
    public static CustomException factCouldNotBeUpdated() {
        return new CustomException(ErrorCode.FACT_COULD_NOT_BE_UPDATED);
    }
    public static CustomException factCouldNotBeDeleted() {
        return new CustomException(ErrorCode.FACT_COULD_NOT_BE_DELETED);
    }
    public static CustomException feedbackCouldNotBeCreated() {
        return new CustomException(ErrorCode.FEEDBACK_COULD_NOT_BE_CREATED);
    }
    public static CustomException feedbackCouldNotBeRead() {
        return new CustomException(ErrorCode.FEEDBACK_COULD_NOT_BE_READ);
    }
    public static CustomException feedbackCouldNotBeFound() {
        return new CustomException(ErrorCode.FEEDBACK_COULD_NOT_BE_FOUND);
    }
    public static CustomException feedbackCouldNotBeUpdated() {
        return new CustomException(ErrorCode.FEEDBACK_COULD_NOT_BE_UPDATED);
    }
    public static CustomException feedbackCouldNotBeDeleted() {
        return new CustomException(ErrorCode.FEEDBACK_COULD_NOT_BE_DELETED);
    }
    public static CustomException imageCouldNotBeCreated() {
        return new CustomException(ErrorCode.IMAGE_COULD_NOT_BE_CREATED);
    }
    public static CustomException imageCouldNotBeRead() {
        return new CustomException(ErrorCode.IMAGE_COULD_NOT_BE_READ);
    }
    public static CustomException imageCouldNotBeFound() {
        return new CustomException(ErrorCode.IMAGE_COULD_NOT_BE_FOUND);
    }
    public static CustomException imageCouldNotBeUpdated() {
        return new CustomException(ErrorCode.IMAGE_COULD_NOT_BE_UPDATED);
    }
    public static CustomException imageCouldNotBeDeleted() {
        return new CustomException(ErrorCode.IMAGE_COULD_NOT_BE_DELETED);
    }
    public static CustomException suggestionCouldNotBeCreated() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_CREATED);
    }
    public static CustomException suggestionCouldNotBeRead() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_READ);
    }
    public static CustomException suggestionCouldNotBeFound() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_FOUND);
    }
    public static CustomException suggestionCouldNotBeUpdated() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_UPDATED);
    }
    public static CustomException suggestionCouldNotBeDeleted() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_DELETED);
    }
    public static CustomException suggestionCouldNotBeApproved() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_APPROVED);
    }
    public static CustomException suggestionCouldNotBeRejected() {
        return new CustomException(ErrorCode.SUGGESTION_COULD_NOT_BE_REJECTED);
    }
    public static CustomException suggestionAlreadyApproved() {
        return new CustomException(ErrorCode.SUGGESTION_ALREADY_APPROVED);
    }
    public static CustomException randomFactCouldNotBeRead() {
        return new CustomException(ErrorCode.RANDOM_FACT_COULD_NOT_BE_READ);
    }
    public static CustomException repositoryCouldNotBeFoundForClass() {
        return new CustomException(ErrorCode.REPOSITORY_COUNT_NOT_BE_FOUND_FOR_CLASS);
    }
    public static CustomException objectCouldNotBeCreated() {
        return new CustomException(ErrorCode.OBJECT_COULD_NOT_BE_CREATED);
    }
    public static CustomException objectCouldNotBeRead() {
        return new CustomException(ErrorCode.OBJECT_COULD_NOT_BE_READ);
    }
    public static CustomException objectCouldNotBeFound() {
        return new CustomException(ErrorCode.OBJECT_COULD_NOT_BE_FOUND);
    }
    public static CustomException objectCouldNotBeUpdated() {
        return new CustomException(ErrorCode.OBJECT_COULD_NOT_BE_UPDATED);
    }
    public static CustomException objectCouldNotBeDeleted() {
        return new CustomException(ErrorCode.OBJECT_COULD_NOT_BE_DELETED);
    }


}
