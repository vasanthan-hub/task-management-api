output "public_ip" {
  value = aws_instance.task_server.public_ip
}

output "public_dns" {
  value = aws_instance.task_server.public_dns
}

output "ssh_command" {
  value = "ssh -i your-key.pem ubuntu@${aws_instance.task_server.public_ip}"
}

output "app_url" {
  value = "http://${aws_instance.task_server.public_ip}:${var.app_port}"
}

output "jenkins_url" {
  value = "http://${aws_instance.task_server.public_ip}:${var.jenkins_port}"
}