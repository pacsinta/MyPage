interface EmailTemplateProps {
    email: string;
    emailBody: string;
}

export const EmailTemplate: React.FC<Readonly<EmailTemplateProps>> = (
    {
        email,
        emailBody,
    }
) => (
    <div>
        <h4>New message received from {email}</h4>
        <p>
            {emailBody}
        </p>
    </div>
);

export const EmailConfirmationTemplate: React.FC<Readonly<EmailTemplateProps>> = (
    {
        emailBody,
    }
) => (
    <div>
        <h4>Thank you for connecting with me!</h4>

        <h5>Your message:</h5>
        <p>
            {emailBody}
        </p>
    </div>
);