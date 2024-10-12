interface Values {
    email: string;
    subject: string;
    emailBody: string;
}

export const sendEmail = async (values: Values) => {
    try {
        const responseMe = await fetch('/api/sendtome', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(values),
        });

        if (responseMe.ok) {
            console.log('Email sent successfully!');
        } else {
            const errorDetails = await responseMe.json();
            console.error('Error sending email:', errorDetails.message);
        }


        const responseSender = await fetch('/api/sendtosender', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(values),
        });

        if (responseSender.ok) {
            console.log('Email sent successfully!');
        } else {
            const errorDetails = await responseSender.json();
            console.error('Error sending email:', errorDetails.message);
        }
    } catch (error) {
        console.error('There was a problem sending the email:', error);
    }
};