import {StyleSheet, Text, TextStyle} from "react-native";

type Props = {
    text: string
    fontWeight: TextStyle['fontWeight']
}

export function TitleText({ text, fontWeight }: Props) {
    return (
        <Text style={[styles.text, { fontWeight: fontWeight}]}>
            { text }
        </Text>
    )
}

const styles = StyleSheet.create({
    text: {
        fontSize: 25,
        color: '#40524c',
        textAlign: 'center'
    }
})