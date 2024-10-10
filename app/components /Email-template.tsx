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